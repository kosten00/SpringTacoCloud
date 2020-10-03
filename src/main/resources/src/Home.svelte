<script>
  import Design from "./Design.svelte";
  import Order from "./Order.svelte";

  import { storedTaco } from "./stores/store.js";

  let taco;

  let design = true;
  let order = false;

  storedTaco.subscribe((value) => {
    taco = value;

    console.log("from subscribe function" + taco.name);

    if (taco.name !== "") {
      design = false;
      order = true;
    }
  });
</script>

{design}
{order}

<style>
  h1 {
    text-align: center;
  }
</style>

<h1>Design your taco!</h1>
<img src="pictures/shaverma.png" alt="" />

{#if design}
  <Design />
{/if}
{#if order}
  <Order />
{/if}
