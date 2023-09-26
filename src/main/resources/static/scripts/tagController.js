document.addEventListener('DOMContentLoaded', function () {
  const flavourContainer = document.querySelector('.flavour-container');
  const pagination = document.querySelector('.pagination');
  const searchBar = document.getElementById('tag-input');
  const pageSizeSelect = document.getElementById('items-per-page-select');
  let flavours = []; // Store flavour data here
  let pageNumber = 1;
  let pageSize = parseInt(pageSizeSelect.value); // Parse the initial value

  // Function to render flavour cards
  function renderFlavorCards(page) {
    flavourContainer.innerHTML = ''; // Clear previous cards
    const startIndex = (page - 1) * pageSize;
    const endIndex = startIndex + pageSize;
    const flavourPage = flavours.slice(startIndex, endIndex);

    flavourPage.forEach((flavour) => {
      const card = document.createElement('div');
      card.classList.add('flavour-card');
      card.textContent = flavour.name;
      flavourContainer.appendChild(card);
    });
  }

  // Function to update pagination controls
  function updatePagination() {
    pagination.innerHTML = '';

    const totalPages = Math.ceil(flavours.length / pageSize);
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
        renderFlavorCards(pageNumber);
        updatePagination();
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


  // Simulated API call to fetch flavours
  function fetchFlavours() {
    fetch('/flavours/all')
      .then((response) => response.json())
      .then((data) => {
        flavours = data;
        renderFlavorCards(pageNumber);
        updatePagination();
      })
      .catch((error) => {
        console.error('Error fetching flavours:', error);
      });
  }

  // Initial fetch
  fetchFlavours();

  // Listen for changes in the <select> element
  pageSizeSelect.addEventListener('change', function () {
    // Update the pageSize variable with the selected value
    pageSize = parseInt(pageSizeSelect.value); // Parse the value as an integer
    pageNumber = 1; // Reset to the first page when changing items per page
    renderFlavorCards(pageNumber); // Re-render cards based on the new items per page
    updatePagination(); // Update pagination controls
  });

  // Simulated API call to fetch flavours
    function searchFlavours() {
        const searchText = searchBar.value != null ? searchBar.value.toLowerCase() : null;
         const url = `/flavours/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}`;
         // Make a GET request to your API endpoint
         fetch(url)
          .then((response) => response.json())
          .then((data) => {
          flavourList = data;
          renderFlavorCards(pageNumber);
          updatePagination();
        })
        .catch((error) => {
          console.error('Error fetching flavours:', error);
        });
    }

    // Initial fetch
    searchFlavours();

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
});
