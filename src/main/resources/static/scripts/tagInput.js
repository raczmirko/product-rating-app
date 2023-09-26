document.addEventListener('DOMContentLoaded', function () {
  const tagInput = document.getElementById('tag-input');
  const selectedTags = document.getElementById('selected-tags');
  const flavourTable = document.getElementById('flavour-table').getElementsByTagName('tbody')[0];
  let flavourList = [];
  var pageSize = 6;
  var pageNumber = 1;

  // Function to fetch flavours and populate the table
  function populateTable() {
    // Make a GET request to your API endpoint
    fetch('/flavours/all')
      .then((response) => response.json())
      .then((data) => {
        flavourList = data;

        // Clear the table body
        flavourTable.innerHTML = '';

        // Add matched flavours to the table
        flavourList.forEach((flavour) => {
          const row = flavourTable.insertRow();
          const cell = row.insertCell(0);
          cell.textContent = flavour.name;

          // Add a click event to select the option
          row.addEventListener('click', () => {
            selectFlavour(flavour.id);
          });
        });
      })
      .catch((error) => {
        console.error('Error fetching flavours:', error);
      });
  }

  function searchFlavours() {
    const searchText = tagInput.value.toLowerCase();
    const url = '/flavours/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}';
    // Make a GET request to your API endpoint
    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        flavourList = data;

        // Clear the table body
        flavourTable.innerHTML = '';

        // Add matched flavours to the table
        flavourList.forEach((flavour) => {
          const row = flavourTable.insertRow();
          const cell = row.insertCell(0);
          cell.textContent = flavour.name;

          // Add a click event to select the option
          row.addEventListener('click', () => {
            selectFlavour(flavour.id);
          });
        });
      })
      .catch((error) => {
        console.error('Error fetching flavours:', error);
      });
  }

  // Function to add a selected tag
  function addTag(tagName) {
    const selectedTag = document.createElement('div');
    selectedTag.classList.add('selected-tag');
    selectedTag.textContent = tagName;

    // Add a click event to remove the tag when clicked
    selectedTag.addEventListener('click', () => {
      selectedTags.removeChild(selectedTag);
    });

    selectedTags.appendChild(selectedTag);
  }

  // Function to select a flavour and add it as a tag
  function selectFlavour(flavourId) {
    const selectedFlavour = flavourList.find((flavour) => flavour.id === flavourId);
    if (selectedFlavour) {
      addTag(selectedFlavour.name);
      tagInput.value = ''; // Clear the input field
      flavourTable.innerHTML = ''; // Clear the table
    }
  }

  // Event listener for input field changes (e.g., user typing)
  tagInput.addEventListener('input', () => {
    searchFlavours();
  });

  // Initialize by populating the table
  populateTable();
});
