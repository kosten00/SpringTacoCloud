<script>
  import { createEventDispatcher } from "svelte";
  let dispatch = createEventDispatcher();

  let tacoIngredients = {};
  let tacoName = "";

  let designMock = [
      {
        name: "Flour Tortilla",
        type: "WRAP",
      },
      { name: "Corn Tortilla", type: "WRAP" },
      {
        name: "Ground Beef",
        type: "PROTEIN",
      },
      {
        name: "Carnitas",
        type: "PROTEIN",
      },
      {
        name: "Diced Tomatoes",
        type: "VEGGIES",
      },
      {
        name: "Lettuce",
        type: "VEGGIES",
      },
      {
        name: "Cheddar",
        type: "CHEESE",
      },
      {
        name: "Monterrey Jack",
        type: "CHEESE",
      },
      {
        name: "Salsa",
        type: "SAUCE",
      },
      {
        name: "Sour Cream",
        type: "SAUCE",
      },
    ];

  // async function doGet() {
  //   const response = await fetch("/design");
  //   const text = await response.text();
  //   if (response.ok) {
  //     return JSON.parse(text);
  //   }
  //   throw new Error(text);
  // }

  function distinctByType(allIngredients) {
    return [...new Set(allIngredients.map((e) => e.type))];
  }

  function finishTacoDesign() {
    const tacoNew = {
      name: tacoName,
      ingredients: Object.values(tacoIngredients),
    };
    dispatch("addTaco", tacoNew);
  }
</script>

<style>
  input {
  outline: none;
  border-width: 2px;
}

.field-danger {
      border-color: red;
  }
</style>

<p>{JSON.stringify(tacoIngredients)}</p>

<!-- {#await doGet()}
  <p>Waiting for server response..</p>
{:then allIngredients}
  <ul>
    {#each distinctByType(allIngredients) as distinctType}
      <li>Choose {distinctType} you like!</li>
      <ul>
        <form>
          {#each allIngredients as { name, type }}
            {#if type === distinctType}
              <li>
                <label><input
                    type="radio"
                    name={type}
                    bind:group={tacoIngredients[type]}
                    value={name} />
                  {name}</label>
              </li>
            {/if}
          {/each}
        </form>
      </ul>
    {/each}
  </ul>
{/await} -->

<ul>
  {#each distinctByType(designMock) as distinctType}
  <li>Choose {distinctType} you like!</li>
      <ul>
        <form>
          {#each designMock as { name, type }}
            {#if type === distinctType}
              <li>
                <label><input
                    type="radio"
                    name={type}
                    bind:group={tacoIngredients[type]}
                    value={name} 
                    class:field-danger={name === ''}/>
                  {name}</label>
              </li>
            {/if}
          {/each}
        </form>
      </ul>
    {/each}
</ul>

<p>Name your Taco creation:</p>
<input bind:value={tacoName} />
<button on:click={finishTacoDesign}> Submit your taco! </button>
