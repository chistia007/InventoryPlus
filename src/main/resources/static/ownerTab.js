    document.getElementById("addUserForm").addEventListener("submit", function(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const user = {};
        formData.forEach((value, key) => {
            user[key] = value;
        });
        console.log(user)
        fetch("/bending/addUser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        })
       .then(response => response.text())
       .then(data => {
           // Display the response message in userInfoContainer-->
           location.reload();
        })
        .catch(error => console.error('Error:', error));
    });


document.addEventListener("DOMContentLoaded", function () {
    // Get modal elements
    const addUserModal = document.getElementById("addUserModal");
    const closeModalButton = document.getElementById("closeModal");

    // Get the "Add User" button
    const addUserButton = document.getElementById("addUserButton");

    // When the "Add User" button is clicked, open the modal
    addUserButton.addEventListener("click", function () {
        addUserModal.style.display = "block";
    });

    // When the close button in the modal is clicked, close the modal
    closeModalButton.addEventListener("click", function () {
        addUserModal.style.display = "none";
    });
});




document.addEventListener("DOMContentLoaded", function () {
    // Get the user list element
    const userList = document.getElementById("userList");

    // Function to load users from the API
    function loadUsers() {
        fetch("/bending/getUsers") // Replace with the actual URL of your API endpoint
            .then((response) => response.json())
            .then((data) => {
                // Clear existing list items
                userList.innerHTML = "";

                // Create list items for each user and append to the list
                data.forEach((user) => {
                    const listItem = document.createElement("li");
                    listItem.textContent = `User Name: ${user.userName}, User Type: ${user.userType}, Salary: ${user.salary}`;
                    userList.appendChild(listItem);
                });
            })
            .catch((error) => {
                console.error("Error fetching users:", error);
            });
    }

    // Load users when the page loads
    loadUsers();
});



 //Adding  event listener for delete user button
document.getElementById("deleteUserButton").addEventListener("click", function(event) {
    const username = document.getElementById('deleteUserName').value; // You need to get the value of the input field

    fetch(`/bending/deleteUser?username=${username}`)
        .then(response => response.json())
        .then(data => {
             location.reload();
        })
        .catch(error => {
            console.error("Error:", error);
        });


});
