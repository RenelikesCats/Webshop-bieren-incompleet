"use strict";

const body = document.getElementById("bierenLijstBody");
const zoekInput = document.getElementById("zoekInput");
let alleBierenData = []; // alle opgehaalde bieren

document.addEventListener("DOMContentLoaded", async () => {
    try {
        const brouwerId = sessionStorage.getItem("brouwerId");
        let bierenLijst;
        const baseUrl = "http://localhost:8080/bieren";
        const url = brouwerId !== null ? `${baseUrl}/${brouwerId}` : baseUrl;

        bierenLijst = await getAlleBieren(url);

        if (bierenLijst) {
            alleBierenData = bierenLijst;
            verwerkBieren(bierenLijst);
        } else {
            console.error("Fout bij het ophalen van de bieren.");

        }
    } catch (error) {
        console.error("Er is een onverwachte fout opgetreden:", error);

    } finally {
        sessionStorage.clear();
    }

    // event listener aan de zoekbalk
    zoekInput.addEventListener("input", filterBieren);
});

async function getAlleBieren(pad) {
    try {
        const response = await fetch(pad);
        if (!response.ok) {
            console.error(`HTTP error! status: ${response.status}`);
            return null;
        }
        return await response.json();
    } catch (error) {
        console.error("Fout bij het uitvoeren van de fetch:", error);
        return null;
    }
}

function verwerkBieren(bieren) {
    body.innerHTML = "";

    if (!bieren || !Array.isArray(bieren)) {
        console.error("Ongeldige data ontvangen om te verwerken:", bieren);
        return;
    }

    bieren.forEach(bier => {
        const tr = body.insertRow();
        const data = [bier.bierNaam, bier.brouwerNaam, bier.alcoholPerc, bier.prijs];

        data.forEach(item => {
            const td = document.createElement('td');
            td.className = "px-6 py-4 whitespace-nowrap text-md text-gray-700";
            td.innerText = item;
            tr.appendChild(td);
        });
    });
}

function filterBieren() {
    const zoekTerm = zoekInput.value.toLowerCase();
    const gefilterdeBieren = alleBierenData.filter(bier => {
        return (
            bier.bierNaam.toLowerCase().includes(zoekTerm) || bier.brouwerNaam.toLowerCase().includes(zoekTerm)
        );
    });
    verwerkBieren(gefilterdeBieren);
}