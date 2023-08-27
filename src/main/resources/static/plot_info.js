// Event listener for the search input
const searchInput = document.getElementById('search');
const searchResults = document.getElementById('search-results');

searchInput.addEventListener('input', function () {
    const query = searchInput.value.trim();

    if (query === '') {
        searchResults.innerHTML = '';
        return;
    }

    console.log('Query:', query);
    fetch('/bending/search?query=' + query)
        .then(response => response.json())
        .then(data => {
            searchResults.innerHTML = '';
            console.log('Data:', data);

            if (data.length > 0) {
                data.forEach(item => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `Id: ${item.plot_id},Name: ${item.productName}, Location: ${item.location}, Image URL: ${item.imageUrl}, Total Quantity: ${item.totalQuantity}, Quantity Sold: ${item.quantitySold}, Quantity Left: ${item.quantityLeft}, Moved To Warehouse: ${item.movedToWarehouse}, Product Grade: ${item.productGrade}, Ploughing Time: ${item.ploughingTime}, Reaping Time: ${item.reapingTime}, Warehouse Id: ${item.wareHouseId}`;

                    listItem.addEventListener('click', () => {
                        displayItemDetails(item);
                    });

                    searchResults.appendChild(listItem);
                });
            } else {
                searchResults.innerHTML = '<li>No results found</li>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});






const itemForm = document.getElementById('item-form');

// Function to display item details and handle CRUD operations
function displayItemDetails(item) {
   const searchResults = document.getElementById('search-results');
   searchResults.innerHTML = '';

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

      // Clearing previous item details and appending the new details
      itemDetails.innerHTML = '';
      itemDetails.appendChild(detailsContainer);  // will be added as a child div of itemDetails




    // Enable the form for editing
    itemForm.style.display = 'block';
    // Populate the form fields with the item's data
    document.getElementById('plot_id').value = item.plot_id;
    document.getElementById('productName').value = item.productName;
    document.getElementById('location').value = item.location;

     document.getElementById('pricePerKg').value = item.pricePerKg;
    document.getElementById('totalQuantity').value = item.totalQuantity;
    document.getElementById('quantitySold').value = item.quantitySold;

     document.getElementById('quantityLeft').value = item.quantityLeft;
    document.getElementById('movedToWareHouse').value = item.movedToWareHouse;
    document.getElementById('productGrade').value = item.productGrade;

    document.getElementById('ploughingTime').value = item.ploughingTime;
    document.getElementById('reapingTime').value = item.reapingTime;
    document.getElementById('wareHouseID').value = item.wareHouseID;
    // Populate other form fields as needed


           document.getElementById("item-form").addEventListener("submit", function(event) {
                 event.preventDefault();
                 const formData = new FormData(event.target);
                 const itemUpdate = {};
                 formData.forEach((value, key) => {
                     itemUpdate[key] = value;
                 });
                 console.log(itemUpdate)
                 fetch("/bending/items/update", {
                     method: "POST",
                     headers: {
                         "Content-Type": "application/json"
                     },
                     body: JSON.stringify(itemUpdate)
                 })
                .then(response => response.text())
              .then(data => {

                   location.reload();
                 })
                 .catch(error => console.error('Error:', error));
             });

}

