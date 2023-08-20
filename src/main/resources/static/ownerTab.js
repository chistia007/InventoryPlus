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
