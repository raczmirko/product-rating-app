document.addEventListener('DOMContentLoaded', function () {
    const tagInput = document.getElementById('tag-input');
    const selectedTags = document.getElementById('selected-tags');
    let flavourDropdown = document.getElementById('flavours-dropdown'); // Declare flavourDropdown variable in the outer scope
    var flavourList = [];

    // Function to fetch flavour and populate the dropdown
    function populateDropdown() {
      // Make a GET request to your API endpoint
      fetch('/flavours/all')
        .then((response) => response.json())
        .then((data) => {

          flavourList = data;
          // Clear existing options
          flavourDropdown.innerHTML = '';

          // Add a default option
          const defaultOption = document.createElement('option');
          defaultOption.value = '';
          defaultOption.text = 'Select Flavor';
          flavourDropdown.appendChild(defaultOption);

          // Add fetched flavour to the dropdown
          data.forEach((flavours) => {
            const option = document.createElement('option');
            option.value = flavours.id;
            option.text = flavours.name;
            flavourDropdown.appendChild(option);
          });
        })
        .catch((error) => {
          console.error('Error fetching flavour:', error);
        });
    }

    function findFlavourName(flavourId) {
      for (const element of flavourList) {
        if(flavourId == element.id){
            return element.name;
        }
      }
      return 'Unknown';
    }

    // Function to add a selected tag
    function addTag(tag) {
      const selectedTag = document.createElement('div');
      selectedTag.classList.add('selected-tag');
      selectedTag.textContent = findFlavourName(tag);

      // Add a click event to remove the tag when clicked
      selectedTag.addEventListener('click', () => {
        selectedTags.removeChild(selectedTag);
      });

      selectedTags.appendChild(selectedTag);
    }

    // Event listener for input field changes (e.g., user typing)
    tagInput.addEventListener('input', () => {
      const searchText = tagInput.value.toLowerCase();
      // Filter flavour based on user input
      const filteredFlavors = flavourList.filter((flavour) =>
        flavour.name.toLowerCase().includes(searchText)
      );
      // Clear existing options
      flavourDropdown.innerHTML = '';
      // Add a default option
      const defaultOption = document.createElement('option');
      defaultOption.value = '';
      defaultOption.text = 'Select Flavor';
      flavourDropdown.appendChild(defaultOption);
      // Add fetched flavour to the dropdown
      filteredFlavors.forEach((filteredFlavor) => {
      const option = document.createElement('option');
      option.value = filteredFlavor.id;
      option.text = filteredFlavor.name;
      flavourDropdown.appendChild(option);
      });
    });

    // Event listener for selecting flavour from the dropdown
    flavourDropdown.addEventListener('change', () => {
      const selectedFlavor = flavourDropdown.value;
      if (selectedFlavor) {
        addTag(selectedFlavor);
        populateDropdown();
        tagInput.value = ''; // Clear the input field
      }
    });

    // Initialize by populating the dropdown
    populateDropdown();
});