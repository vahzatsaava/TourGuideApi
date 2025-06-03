const API_BASE = 'https://tourguideapi.onrender.com/api/v1';

const tourList = document.getElementById('tour-list');
const modal = document.getElementById('modal');
const closeBtn = document.getElementById('close');
const bookingForm = document.getElementById('bookingForm');
const dateInput = document.getElementById('date');
const feedback = document.getElementById('feedback');

const today = new Date();
today.setDate(today.getDate() + 1);
const minDate = today.toISOString().split('T')[0];
dateInput.min = minDate;

async function loadTours() {
    console.log("Loading tours...");
    try {
        const res = await fetch(`${API_BASE}/tours`);
        const tours = await res.json();

        tours.forEach(tour => {
            const card = document.createElement('div');
            card.className = 'card';
            card.innerHTML = `
                <img src="${tour.images[0] || 'https://via.placeholder.com/300'}" />
                <h3>${tour.name}</h3>
                <p>${tour.description}</p>
                <button onclick="openBooking(${tour.id})">Book</button>
            `;
            tourList.appendChild(card);
        });
    } catch (err) {
        console.error("Ошибка при получении туров:", err);
        tourList.innerHTML = `<p style="color:red;">Ошибка загрузки туров. Проверь CORS на сервере!</p>`;
    }
}

function openBooking(tourId) {
    document.getElementById('tourId').value = tourId;
    modal.classList.remove('hidden');
    feedback.textContent = ''; // очистить старое сообщение
}

closeBtn.onclick = () => {
    modal.classList.add('hidden');
};

bookingForm.onsubmit = async (e) => {
    e.preventDefault();

    const tourId = document.getElementById('tourId').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;
    const date = document.getElementById('date').value;

    try {
        const res = await fetch(`${API_BASE}/bookings`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ tourId, email, message, date })
        });

        if (res.ok) {
            feedback.textContent = 'Book created!';
            bookingForm.reset();
        } else {
            feedback.textContent = 'Ошибка при бронировании!';
        }
    } catch (error) {
        feedback.textContent = 'Ошибка сети! Проверь подключение.';
    }
};

loadTours();
