"use strict";

const mandjeOverzicht = document.getElementById("mandje-div");
document.addEventListener("DOMContentLoaded", () => {
    let bestellingen = JSON.parse(sessionStorage.getItem("mandje")) || [];
    toonMandje(bestellingen);
});

function toonMandje(bestellingen) {
    mandjeOverzicht.innerHTML = "";

    if (bestellingen && Array.isArray(bestellingen)) {
        bestellingen.forEach((bestelling, index) => {
            const bestellingDiv = document.createElement("div");
            bestellingDiv.classList.add("mb-4", "border-b", "pb-2", "items-center");

            const naamP = document.createElement("p");
            naamP.textContent = `Biernaam: ${bestelling.bierNaam}`;
            naamP.classList.add("mr-4");
            bestellingDiv.append(naamP);

            const prijsP = document.createElement("p");
            prijsP.textContent = `Prijs: € ${bestelling.prijs}`;
            prijsP.classList.add("mr-4");
            bestellingDiv.append(prijsP);

            const aantalDiv = document.createElement("div");
            aantalDiv.classList.add("flex", "items-center");

            const verminderKnop = document.createElement("button");
            verminderKnop.textContent = "-";
            verminderKnop.classList.add("px-2", "py-1", "bg-gray-300", "text-gray-700", "rounded", "mr-2");
            verminderKnop.addEventListener("click", () => wijzigAantal(index, -1));
            aantalDiv.append(verminderKnop);

            const aantalSpan = document.createElement("span");
            aantalSpan.textContent = bestelling.aantal;
            aantalSpan.classList.add("mr-2");
            aantalDiv.append(aantalSpan);

            const vermeerderKnop = document.createElement("button");
            vermeerderKnop.textContent = "+";
            vermeerderKnop.classList.add("px-2", "py-1", "bg-gray-300", "text-gray-700", "rounded");
            vermeerderKnop.addEventListener("click", () => wijzigAantal(index, 1));
            aantalDiv.append(vermeerderKnop);

            bestellingDiv.append(aantalDiv);
            mandjeOverzicht.append(bestellingDiv);
        });
    } else {
        console.log("Het mandje is leeg of bevat ongeldige data.");
        const leegMelding = document.createElement("p");
        leegMelding.textContent = "Het mandje is leeg.";
        mandjeOverzicht.append(leegMelding);
    }
}

function wijzigAantal(index, verandering) {
    let bestellingen = JSON.parse(sessionStorage.getItem("mandje"));
    if (bestellingen && Array.isArray(bestellingen) && index >= 0 && index < bestellingen.length) {
        bestellingen[index].aantal += verandering;
        if (bestellingen[index].aantal < 1) {
            bestellingen.splice(index, 1);
        }
        sessionStorage.setItem("mandje", JSON.stringify(bestellingen));
        toonMandje(bestellingen); // Herlaad het mandje overzicht
    }
}

document.getElementById("verderBtn").addEventListener("click", () => window.location = "formulier.html")