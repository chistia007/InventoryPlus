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
                    listItem.textContent = `Name: ${item.name}, Id: ${item.id}`;

                    data.forEach(item => {
                        const listItem = document.createElement('li');
                        listItem.textContent = `Name: ${item.name}, Description: ${item.description}`;

                        // Add click event listeners to each search result item if needed

                        searchResults.appendChild(listItem);
                    });

                    // Add a click event listener to each search result item
                    listItem.addEventListener('click', () => {
                        displayItemDetails(item);
                    });

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

