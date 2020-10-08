<script>
  import Design from "./components/design/Design.svelte";
  import Order from "./components/order/Order.svelte";

  let taco = {};

  let showDesign = true;
  let showOrderDetails = false;

  const addTaco = (e) => {
    taco = e.detail;

    showDesign = false;
    showOrderDetails = true;
  };
</script>

<style>
  h1 {
    text-align: center;
  }
</style>

<p>{JSON.stringify(taco)}</p>
<h1>Design your taco!</h1>
<img src="pictures/shaverma.png" alt="" />

{#if showDesign}
<Design on:addTaco={addTaco} />
{/if}

{#if showOrderDetails}
<Order />
{/if}
