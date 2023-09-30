//--------------------------------------------------------------|
//-----Script for handling the food/drink button functions-----//
//--------------------------------------------------------------|

// Get references to the button and the initial state
const toggleButton = document.getElementById("toggleButton");
let isDrink = true; // Initial state (true for "Drink")

// Add a click event listener to the button
toggleButton.addEventListener("click", function () {
// Toggle the text and color of the button
isDrink = !isDrink; // Toggle the boolean value
toggleButton.textContent = isDrink ? "Drink" : "Food";
toggleButton.classList.toggle("toggle-food");

// Toggle the background image based on the state
const drinkImage = '/images/drink_button_background.png';
const foodImage = '/images/food_button_background.png';
toggleButton.style.backgroundImage = isDrink ? `url('${drinkImage}')` : `url('${foodImage}')`;

// Update the hidden checkbox input's checked state
const checkbox = document.getElementById("isDrinkHidden");
checkbox.checked = isDrink;
});
