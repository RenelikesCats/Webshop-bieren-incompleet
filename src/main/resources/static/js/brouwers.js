"use strict";

const brouwersLijst = document.getElementById("brouwersLijst");

document.addEventListener("DOMContentLoaded", async () => {
    const brouwers = await getBrouwers();
    brouwers !== null ? await verwerkBrouwers(brouwers) : console.error("Brouwer not found");
})

async function getBrouwers() {
    const response = await fetch("http://localhost:8080/brouwers");
    if (response.ok) {
        return await response.json()
    }
    return null
}

async function verwerkBrouwers(brouwers) {
    for (const brouwer of brouwers) {
        const div = document.createElement("div");
        div.className = "bg-white rounded-lg shadow-md p-6 cursor-pointer hover:bg-yellow-500";
        brouwersLijst.appendChild(div);

        const naamElement = document.createElement("h3");
        naamElement.className = "text-lg font-semibold mb-2";
        naamElement.textContent = brouwer.naam;
        div.appendChild(naamElement);

        const gemeenteElement = document.createElement("p");
        gemeenteElement.textContent = brouwer.gemeente;
        div.appendChild(gemeenteElement);

        const aantalBieren = await getAantalBierenPerBrouwer(brouwer.id);

        if (aantalBieren !== null) {
            const aantalElement = document.createElement("p");
            aantalElement.textContent = `Aantal bieren: ${aantalBieren}`;
            div.appendChild(aantalElement);
        }

        const detailsElement = document.createElement("details");
        detailsElement.className = "mt-4";
        div.appendChild(detailsElement);

        const summaryElement = document.createElement("summary");
        summaryElement.textContent = "Meer info";
        detailsElement.appendChild(summaryElement);

        const adresInfo = [brouwer.straat, brouwer.huisNr, brouwer.postcode].filter(Boolean).join(', ');

        if (adresInfo) {
            const adresElement = document.createElement("p");
            adresElement.textContent = adresInfo;
            detailsElement.appendChild(adresElement);
        }

        div.addEventListener("click", () => {
            sessionStorage.setItem("brouwerId", brouwer.id);
            window.location = "/alleBierenVanEenBrouwer.html";
        });
    }
}

async function getAantalBierenPerBrouwer(brouwerId) {
    const response = await fetch(`http://localhost:8080/bieren/brouwer/aantal/${brouwerId}`);
    if (response.ok) {
        return await response.json()
    }
    return null
}







