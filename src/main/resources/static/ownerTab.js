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
           location.reload();
        })
        .catch(error => console.error('Error:', error));
    });


document.addEventListener("DOMContentLoaded", function () {
    const addUserModal = document.getElementById("addUserModal");
    const closeModalButton = document.getElementById("closeModal");

    const addUserButton = document.getElementById("addUserButton");

    addUserButton.addEventListener("click", function () {
        addUserModal.style.display = "block";
    });

    closeModalButton.addEventListener("click", function () {
        addUserModal.style.display = "none";
    });
});




document.addEventListener("DOMContentLoaded", function () {
    const userList = document.getElementById("userList");

    function loadUsers() {
        fetch("/bending/getUsers")
            .then((response) => response.json())
            .then((data) => {

                userList.innerHTML = "";

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

    loadUsers();
});



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
