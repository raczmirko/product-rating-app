//--------------------------------------------------------------|
//-----Script for handling the popup window functionality------//
//--------------------------------------------------------------|
function showModal(thingToDelete, index) {
    // Get the modal
    var modal = document.getElementById("modal");
    // Get the text on modal
    // Get a reference to the message element by its id
    const popupMessage = document.getElementById("popup-message");
    popupMessage.textContent  = "Are you sure want to delete this".concat(" ", thingToDelete, "?");
    // When the user clicks the button, open the modal
    modal.style.display = "block";
    // Get the <span> element that closes the modal
    var cancelButton = document.getElementById("modal-no");
    var confirmButton = document.getElementById("modal-yes");
    confirmButton.onclick = function() {
        console.log("Just the element: ", document.getElementById("productIndex"));
        const formID = "deletion-form-".concat(index.current.id);
        console.log(formID)
        const deletionForm = document.getElementById(formID);
        deletionForm.submit();
    }
    cancelButton.onclick = function() {
        modal.style.display = "none";
    }
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}