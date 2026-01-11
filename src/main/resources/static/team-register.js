function register() {

    const bgmiId = document.getElementById("bgmiId").value.trim();
    const age = document.getElementById("age").value.trim();
    const whatsapp = document.getElementById("whatsapp").value.trim();

    const bgmiError = document.getElementById("bgmiError");
    const ageError = document.getElementById("ageError");
    const waError = document.getElementById("waError");

    // reset previous errors
    bgmiError.innerText = "";
    ageError.innerText = "";
    waError.innerText = "";

    let hasError = false;

    // BGMI ID check
    if (!/^\d{8,10}$/.test(bgmiId)) {
        bgmiError.innerText = "BGMI ID must be 8–10 digits";
        hasError = true;
    }

    // Age check
    if (!age || parseInt(age) < 18) {
        ageError.innerText = "Age must be 18 or above";
        hasError = true;
    }

    // WhatsApp check
    if (!/^\d{10}$/.test(whatsapp)) {
        waError.innerText = "WhatsApp number must be exactly 10 digits";
        hasError = true;
    }

    // ❌ agar koi error hai → backend call hi nahi hoga
    if (hasError) return;

    // ✅ send data
    const data = {
        teamName: document.getElementById("teamName").value.trim(),
        leaderName: document.getElementById("leaderName").value.trim(),
        bgmiId: bgmiId,
        age: parseInt(age),
        whatsappNumber: whatsapp
    };

    fetch("/api/player/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(res => {
        if (!res.ok) return res.text().then(e => { throw e; });
        return res.text();
    })
    .then(() => {
        document.getElementById("successPopup").style.display = "flex";
    })
    .catch(err => {
        // duplicate BGMI ID error yahin dikhe
        bgmiError.innerText = err;
    });
}
