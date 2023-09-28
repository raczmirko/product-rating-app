document.addEventListener('DOMContentLoaded', function () {

    //------------------------------------|
    //--------------Variables-------------|
    //------------------------------------|

    const flavourContainer = document.querySelector('.flavour-container');
    const pagination = document.querySelector('.pagination');
    const searchBar = document.getElementById('tag-input');
    const pageSizeSelect = document.getElementById('items-per-page-select');
    const resetFiltersButton = document.getElementById('reset-filters-button');
    const selectedTag = document.querySelector('.selected-tag');
    const form = document.querySelector('form');
    let searchText = '';
    let flavours = []; // Store flavour data here
    let pageNumber = 1;
    let pageSize = parseInt(pageSizeSelect.value); // Parse the initial value
    let totalElements = 0;
    // Define an array to store selected flavors (tags)
    const selectedFlavors = [];
    const selectedFlavorIDs = [];
    let url = `/flavours/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}`;

    //------------------------------------|
    //-----------Method calls-------------|
    //------------------------------------|

    // Initial fetch
    searchFlavours();

    //------------------------------------|
    //--------------Functions-------------|
    //------------------------------------|

    // Function to render flavour cards
    function renderFlavorCards(page) {
        flavourContainer.innerHTML = ''; // Clear previous cards

        flavours.forEach((flavour) => {
          const card = document.createElement('div');
          card.classList.add('flavour-card');
          card.textContent = flavour.name;
          flavourContainer.appendChild(card);
        });
    }

    // Function to update pagination controls
    function updatePagination() {
        pagination.innerHTML = '';

        const totalPages = Math.ceil(totalElements / pageSize);
        const buttonsToShow = 3; // Number of buttons to show in pagination

        // Calculate the range of page numbers to display
        let startPage = pageNumber - Math.floor(buttonsToShow / 2);
        let endPage = pageNumber + Math.floor(buttonsToShow / 2);

        // Ensure the range is within valid page numbers
        if (startPage < 1) {
          startPage = 1;
          endPage = Math.min(totalPages, buttonsToShow);
        } else if (endPage > totalPages) {
          endPage = totalPages;
          startPage = Math.max(1, totalPages - buttonsToShow + 1);
        }

        // Helper function to create a pagination button
        function createPaginationButton(text, page) {
          const pageLink = document.createElement('span');
          pageLink.textContent = text;
          pageLink.classList.add('page-link');
          if (page === pageNumber) {
            pageLink.classList.add('active');
          }
          pageLink.addEventListener('click', () => {
            pageNumber = page;
            searchFlavours();
          });
          pagination.appendChild(pageLink);
        }

        // Create the << button to go to the first page
        if (pageNumber > 1) {
          createPaginationButton('<<', 1);
        }

        // Create the < button to go one page back
        if (pageNumber > 1) {
          createPaginationButton('<', pageNumber - 1);
        }

        // Create page buttons for the range
        for (let page = startPage; page <= endPage; page++) {
          createPaginationButton(page.toString(), page);
        }

        // Create the > button to go one page forward
        if (pageNumber < totalPages) {
          createPaginationButton('>', pageNumber + 1);
        }

        // Create the >> button to go to the last page
        if (pageNumber < totalPages) {
          createPaginationButton('>>', totalPages);
        }
    }

    function searchFlavours() {
        searchText = searchBar.value != null ? searchBar.value.toLowerCase() : null;
        url = `/flavours/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}`;
         fetch(url)
          .then((response) => response.json())
          .then((data) => {
          flavours = data.content;
          totalElements = data.totalElements;
          renderFlavorCards(pageNumber);
          updatePagination();
        })
        .catch((error) => {
          console.error('Error fetching flavours:', error);
        });
    }

    // Function to add a selected flavor (tag)
    function addSelectedFlavor(flavor) {
      selectedFlavors.push(flavor);

      // Update the visual representation of selected flavors
      const selectedTagsContainer = document.getElementById('selected-tags');
      const tagElement = document.createElement('span');
      tagElement.textContent = flavor;
      tagElement.classList.add('selected-tag');
      // Adding a colour-changing CSS animation to the selected card
      tagElement.classList.add('color-animation');

      // Add an event listener to remove the tag when clicked
      tagElement.addEventListener('click', () => {
        removeSelectedFlavor(flavor);
      });

      selectedTagsContainer.appendChild(tagElement);
    }

    // Function to remove a selected flavor (tag)
    function removeSelectedFlavor(flavor) {
      const flavorIndex = selectedFlavors.indexOf(flavor);
      if (flavorIndex !== -1) {
        selectedFlavors.splice(flavorIndex, 1);

        // Update the visual representation of selected flavors
        const selectedTagsContainer = document.getElementById('selected-tags');
        const tagElements = selectedTagsContainer.querySelectorAll('.selected-tag');
        tagElements.forEach((tagElement) => {
          if (tagElement.textContent === flavor) {
            selectedTagsContainer.removeChild(tagElement);
          }
        });
      }
    }

    // Helper function to get the flavor ID by name
    function getFlavorIDByName(flavorName) {
      // You can search for the flavor ID in your 'flavours' array
      // Assuming that 'flavours' is an array of objects with 'name' and 'id' properties
      const flavor = flavours.find((flavor) => flavor.name === flavorName);
      return flavor ? flavor.id : null;
    }

    // Function to update the form's hidden input field with selected flavors
    function updateSelectedFlavorsInput() {
      const selectedFlavorsInput = document.getElementById('selected-flavors-input');
      selectedFlavorsInput.value = selectedFlavorIDs.join(',');
    }

    //------------------------------------|
    //-----------Event listeners----------|
    //------------------------------------|

    // Listen for changes in the <select> element
    pageSizeSelect.addEventListener('change', function () {
          // Update the pageSize variable with the selected value
          pageSize = parseInt(pageSizeSelect.value); // Parse the value as an integer
          pageNumber = 1; // Reset to the first page when changing items per page
          renderFlavorCards(pageNumber); // Re-render cards based on the new items per page
          updatePagination(); // Update pagination controls
        });

    // Event listener for input field changes (e.g., user typing)
    searchBar.addEventListener('input', () => {
      searchFlavours();
    });

    // Event listener for flavor card clicks
    flavourContainer.addEventListener('click', (event) => {
          if (event.target.classList.contains('flavour-card')) {
            const selectedFlavor = event.target.textContent;
            const selectedFlavorID = getFlavorIDByName(selectedFlavor);

            // Check if the flavor is not already selected
            if (!selectedFlavors.includes(selectedFlavor)) {
              // Add the selected flavor to the list
              addSelectedFlavor(selectedFlavor);
              // Add the selected flavor's ID to the IDs list
              selectedFlavorIDs.push(selectedFlavorID);
            }
          }
    });

    // Listen for changes in the <select> element
    pageSizeSelect.addEventListener('change', function () {
        // Update the pageSize variable with the selected value
        pageSize = parseInt(pageSizeSelect.value); // Parse the value as an integer
        pageNumber = 1; // Reset to the first page when changing items per page
        searchFlavours();
    });

    // Event listener for form submission
    form.addEventListener('submit', () => {
      // Update the hidden input field with selected flavors
      updateSelectedFlavorsInput();
    });

    //Event listener for resetting filters
    resetFiltersButton.addEventListener('click', (event) => {
        searchText = '';
        searchBar.value = '';
        pageSize = 10;
        pageSizeSelect.value = 10;
        pageNumber = 1;
        searchFlavours();
    });
});
