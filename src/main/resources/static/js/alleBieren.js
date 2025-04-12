"use strict"

const body = document.getElementById("bierenLijstBody")
document.addEventListener("DOMContentLoaded", async () => {
    const bierenLijst = await getAlleBieren()
    bierenLijst !== null ? verwerkBieren(bierenLijst) : console.log("Error met ophalen")


})

async function getAlleBieren() {
    const response = await fetch(`http://localhost:8080/bieren`)
    if (response.ok) {
        return await response.json()
    }
    return null
}

function verwerkBieren(bieren) {
    for (const bier of bieren) {
        const tr = body.insertRow()
        const data = [bier.bierNaam, bier.brouwerNaam, bier.alcoholPerc, bier.prijs]

        for (let i = 0; i < data.length; i++) {
            const td = document.createElement('td')
            td.className = "px-6 py-4 whitespace-nowrap text-md text-gray-700"
            td.innerText = data[i]
            tr.appendChild(td)
        }
    }
}