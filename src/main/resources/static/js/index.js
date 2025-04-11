"use strict"

document.addEventListener("DOMContentLoaded", async () => {
    const aantalBierenSpan = document.getElementById("aantalBieren")
    const aantal = await getAantalBieren();

    aantal !== null ? aantalBierenSpan.innerText = aantal : aantalBierenSpan.innerText = "meer dan 1000";
})

async function getAantalBieren() {
    const response = await fetch(`http://localhost:8080/bieren/findAantalBieren`)
    if (response.ok) {
        return await response.json()
    }
    return null
}

