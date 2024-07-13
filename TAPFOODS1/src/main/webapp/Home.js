document.addEventListener('DOMContentLoaded', function() {
    const leftArrow = document.querySelector('.left-arrow');
    const rightArrow = document.querySelector('.right-arrow');
    const restaurantContainer = document.querySelector('.restaurant-container');

    leftArrow.addEventListener('click', function() {
        restaurantContainer.scrollBy({
            top: 0,
            left: -200,
            behavior: 'smooth'
        });
    });

    rightArrow.addEventListener('click', function() {
        restaurantContainer.scrollBy({
            top: 0,
            left: 200,
            behavior: 'smooth'
        });
    });
});
