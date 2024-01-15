$(document).ready(function () {
    // Event handler for incrementing quantity
    $('.quantity .increment').click(function () {
        var quantityElement = $(this).closest('.item').find('.quantity .no');
        var currentQuantity = parseInt(quantityElement.text());
        quantityElement.text(currentQuantity + 1);

        // Update total price when quantity changes
        updateTotalPrice();
    });

    // Event handler for decrementing quantity
    $('.quantity .decrement').click(function () {
        var quantityElement = $(this).closest('.item').find('.quantity .no');
        var currentQuantity = parseInt(quantityElement.text());
        if (currentQuantity > 1) {
            quantityElement.text(currentQuantity - 1);

            // Update total price when quantity changes
            updateTotalPrice();
        }
    });

    // Event handler for deleting item
    $('.delete .x').click(function () {
        $(this).closest('.item').remove();

        // Update total price when item is deleted
        updateTotalPrice();
    });

    // Function to update total price
    function updateTotalPrice() {
        var totalPrice = 0;

        $('.listCart .item').each(function () {
            var priceElement = $(this).find('.total');
            var quantityElement = $(this).find('.quantity .no');

            var menuPrice = parseFloat(priceElement.text().replace('RM', ''));
            var quantity = parseInt(quantityElement.text());

            totalPrice += menuPrice * quantity;
        });

        $('#totalValue').text(totalPrice.toFixed(2));
    }

    // Example: Add an event listener for the Check Out button
    $('#submit').click(function () {
        alert('Implement your checkout logic here!');
    });
});


