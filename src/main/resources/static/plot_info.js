// Event listener for the search input
const searchInput = document.getElementById('search');
const searchResults = document.getElementById('search-results');

searchInput.addEventListener('input', function () {
    const query = searchInput.value.trim();

    if (query === '') {                              // Check if the query is empty, and if so, clear the search results
        searchResults.innerHTML = '';
        return; // Exit the function early
    }

    // Make an AJAX request to your Java servlet with the correct context path
    console.log('Query:', query);
    fetch('/bending/search?query=' + query)
        .then(response => response.json())
        .then(data => {
            // Clear previous search results
            searchResults.innerHTML = '';
            console.log('Data:', data);

            // Display search results if there are any
            if (data.length > 0) {
                data.forEach(item => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `Id: ${item.plot_id},Name: ${item.productName}, Location: ${item.location}, Image URL: ${item.imageUrl}, Total Quantity: ${item.totalQuantity}, Quantity Sold: ${item.quantitySold}, Quantity Left: ${item.quantityLeft}, Moved To Warehouse: ${item.movedToWarehouse}, Product Grade: ${item.productGrade}, Ploughing Time: ${item.ploughingTime}, Reaping Time: ${item.reapingTime}, Warehouse Id: ${item.wareHouseId}`;

                    // Add a click event listener to each search result item
                    listItem.addEventListener('click', () => {
                        displayItemDetails(item);
                    });

                    // Append the list item to the search results
                    searchResults.appendChild(listItem);
                });
            } else {
                // Handle case when no results are found
                searchResults.innerHTML = '<li>No results found</li>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

// Function to display item details (you need to implement this)
function displayItemDetails(item) {
    const itemDetails = document.getElementById('item-details');

    // Create HTML elements to display the item details
    const detailsContainer = document.createElement('div');
    detailsContainer.classList.add('item-details-container');

    // Populate the detailsContainer with item information
    detailsContainer.innerHTML = `
        <h2>Item Details</h2>
        <p><strong>Id:</strong> ${item.plot_id}</p>
        <p><strong>Name:</strong> ${item.productName}</p>
        <p><strong>Location:</strong> ${item.location}</p>

        <p><strong>Total Quantity:</strong> ${item.totalQuantity}</p>
        <p><strong>Quality Sold:</strong> ${item.quantitySold}</p>
        <p><strong>Quality Left:</strong> ${item.quantityLeft}</p>

        <p><strong>Moved to Warehouse:</strong> ${item.movedToWarehouse}</p>
        <p><strong>Product Grade:</strong> ${item.productGrade}</p>
        <p><strong>Location:</strong> ${item.location}</p>

        <p><strong>Ploughing Time:</strong> ${item.ploughingTime}</p>
        <p><strong>Reaping Time:</strong> ${item.reapingTime}</p>
         <p><strong>Warehouse ID:</strong> ${item.wareHouseId}</p>
        <!-- Add more details here as needed -->
    `;

    // Clear previous item details and append the new details
    itemDetails.innerHTML = '';
    itemDetails.appendChild(detailsContainer);   // appendChild(), you place the detailsContainer element inside itemDetails
}
