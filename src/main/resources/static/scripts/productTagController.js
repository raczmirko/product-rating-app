document.addEventListener('DOMContentLoaded', function () {

    //------------------------------------|
    //--------------Variables-------------|
    //------------------------------------|

    const productContainer = document.querySelector('.product-container');
    const pagination = document.querySelector('.pagination');
    const searchBar = document.getElementById('tag-input');
    const pageSizeSelect = document.getElementById('items-per-page-select');
    const form = document.querySelector('form');
    let searchText = '';
    let products = []; // Store product data here
    let pageNumber = 1;
    let pageSize = parseInt(pageSizeSelect.value); // Parse the initial value
    let totalElements = 0;
    let selectedProduct = undefined;
    let selectedProductID = undefined; // Store selected product ID
    let url = `/products/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}`;

    //------------------------------------|
    //-----------Method calls-------------|
    //------------------------------------|

    // Initial fetch
    searchProducts();

    //------------------------------------|
    //--------------Functions-------------|
    //------------------------------------|

    // Function to render product cards
    function renderProductCards(page) {
    productContainer.innerHTML = ''; // Clear previous cards

    products.forEach((product) => {
      const card = document.createElement('div');
      card.classList.add('product-card');
      card.textContent = product.name;
      productContainer.appendChild(card);
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
        searchProducts();
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

    function searchProducts() {
        searchText = searchBar.value != null ? searchBar.value.toLowerCase() : null;
        url = `/products/search?searchText=${searchText}&pageSize=${pageSize}&pageNumber=${pageNumber}`;
         fetch(url)
          .then((response) => response.json())
          .then((data) => {
          products = data.content;
          totalElements = data.totalElements;
          renderProductCards(pageNumber);
          updatePagination();
        })
        .catch((error) => {
          console.error('Error fetching products:', error);
        });
    }

    function selectProduct(productName, productID) {
      // Remove any existing selected product tag
      removeSelectedProduct();

      selectedProduct = productName;
      selectedProductID = productID;

      // Update the visual representation of selected products
      const selectedTagsContainer = document.getElementById('selected-tags');
      const tagElement = document.createElement('span');
      tagElement.textContent = productName;
      tagElement.classList.add('selected-tag');

      // Add an event listener to remove the tag when clicked
      tagElement.addEventListener('click', () => {
        removeSelectedProduct();
      });

      selectedTagsContainer.appendChild(tagElement);
    }

    // Function to remove the selected product (tag)
    function removeSelectedProduct() {
      // Update the visual representation of selected products
      const selectedTagsContainer = document.getElementById('selected-tags');
      selectedTagsContainer.innerHTML = ''; // Clear all tags
    }

    // Helper function to get the product ID by name
    function getProductIDByName(productName) {
      // You can search for the product ID in your 'products' array
      // Assuming that 'products' is an array of objects with 'name' and 'id' properties
      const product = products.find((product) => product.name === productName);
      return product ? product.id : null;
    }

    // Function to update the form's hidden input field with selected products (tags)
    function updateSelectedProductInput() {
      const selectedProductInput = document.getElementById('product-input');
      selectedProductInput.value = selectedProductID;
    }

    //------------------------------------|
    //-----------Event listeners----------|
    //------------------------------------|

    // Listen for changes in the <select> element
    pageSizeSelect.addEventListener('change', function () {
      // Update the pageSize variable with the selected value
      pageSize = parseInt(pageSizeSelect.value); // Parse the value as an integer
      pageNumber = 1; // Reset to the first page when changing items per page
      renderProductCards(pageNumber); // Re-render cards based on the new items per page
      updatePagination(); // Update pagination controls
    });

    // Event listener for input field changes (e.g., user typing)
    searchBar.addEventListener('input', () => {
      searchProducts();
    });

    // Event listener for product card clicks
    productContainer.addEventListener('click', (event) => {
      if (event.target.classList.contains('product-card')) {
        const productName = event.target.textContent;
        const productID = getProductIDByName(productName);

        // Check if the product is not already selected
        if (productName !== selectedProduct) {
          // Add the selected product to the list
          selectProduct(productName, productID);
        }
      }
    });

    // Listen for changes in the <select> element
    pageSizeSelect.addEventListener('change', function () {
        // Update the pageSize variable with the selected value
        pageSize = parseInt(pageSizeSelect.value); // Parse the value as an integer
        pageNumber = 1; // Reset to the first page when changing items per page
        searchProducts();
        renderProductCards(pageNumber); // Re-render cards based on the new items per page
        updatePagination(); // Update pagination controls
    });

    // Event listener for form submission
    form.addEventListener('submit', () => {
      // Update the hidden input field with selected products
      updateSelectedProductInput();
    });
});
