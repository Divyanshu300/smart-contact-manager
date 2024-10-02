console.log("Script Loaded");

let currentTheme = getTheme();

//initial State
changeTheme();

function changeTheme() {
    //Set to web Page
    document.querySelector('html').classList.add(currentTheme);

    //Set the listener to change theme button
    const changeThemeButton = document.getElementById("theme_change_button");
    
    
    changeThemeButton.addEventListener("click" , (event) => {
        document.querySelector('html').classList.remove(currentTheme);
        
        currentTheme = currentTheme === "light" ? "dark" : "light";
        changeThemeButton.querySelector("span").textContent = (currentTheme === "light") ? "Dark" : "Light";
        
        setTheme(currentTheme);
        
        document.querySelector('html').classList.add(currentTheme);
    }) 
}

//Set Theme to Local Storage
function setTheme(theme) {
    localStorage.setItem("theme" , theme);
}

//Get theme from Local Storage
function getTheme() {
    return localStorage.getItem("theme");
}