// Event listener for the search input
const searchInput = document.getElementById('search');
const searchResults = document.getElementById('search-results');

searchInput.addEventListener('input', function () {
    const query = searchInput.value.trim();

    // Check if the query is empty, and if so, clear the search results
    if (query === '') {
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
    // Implement this function to display the details of the clicked item
    // You can access item properties like item.productName and item.plot_id
    // and update your HTML to show the details.
}
