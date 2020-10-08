<script>
    import { Order } from "../../classes/Order.js";
   
    let order = new Order();

    function doPost() {
        let string = JSON.stringify(order);
        console.log(string);
    }
</script>

<style>
    input {
        outline: none;
        border-width: 2px;
        border-color: green;
    }

    .field-danger {
        border-color: red;
    }
</style>

<p>{order.name}</p>

<h3>Deliver my taco to:</h3>
<label>Name:
    <input
        type="text"
        bind:value={order.name}
        class:field-danger={!order.hasValidName()} />
</label>
<label>Street:
    <input
        type="text"
        bind:value={order.street}
        class:field-danger={!order.hasValidStreet()} /></label>
<label>City:
    <input
        type="text"
        bind:value={order.city}
        class:field-danger={!order.hasValidCity()} />
</label>
<label>State:
    <input
        type="text"
        bind:value={order.state}
        class:field-danger={!order.hasValidState()} /></label>
<label>Zip code:
    <input
        type="text"
        bind:value={order.zip}
        class:field-danger={!order.hasValidZip()} /></label>
<h3>Payment details:</h3>
<label>Credit Card #:
    <input
        type="text"
        bind:value={order.creditCard}
        class:field-danger={!order.hasValidCc()} /></label>
<label>Expiration:
    <input
        type="text"
        bind:value={order.creditCardExpiration}
        class:field-danger={!order.hasValidCcExpiration()} /></label>
<label>CVV:
    <input
        type="text"
        bind:value={order.cvv}
        class:field-danger={!order.hasValidCvv()} /></label>

<button on:click={doPost} disabled={!order.hasAllFiledsValid()}>Submit my order!</button>
