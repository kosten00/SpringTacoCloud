<script>
  let tacoIngredients = {};
  let tacoName = "";

  async function doGet() {
    const response = await fetch("/design");
    const text = await response.text();

    if (response.ok) {
      return JSON.parse(text);
    }
    throw new Error(text);
  }

  function distinctByType(allIngredients) {
    return [...new Set(allIngredients.map((e) => e.type))];
  }

  function finishTacoDesign() {
    const tacoNew = {
      name: tacoName,
      ingredients: Object.values(tacoIngredients),
    };

    //redirect
  }
</script>

<p>{JSON.stringify(tacoIngredients)}</p>

{#await doGet()}
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
{/await}

<p>Name your Taco creation:</p>
<input bind:value={tacoName} />
<button on:click={finishTacoDesign}> Submit your taco! </button>
