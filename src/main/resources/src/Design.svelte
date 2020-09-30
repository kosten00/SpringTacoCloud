<script>
  async function doGet() {
    const response = await fetch("/design");
    
    if (response.ok) {
      return JSON.parse(await response.text());
    }

    throw new Error("Server is not responding");
  }

  let distinct = (ingredients) => {
    return [...new Set(ingredients.map((e) => e.type))];
  };
</script>

{#await doGet()}
  <p>Waiting for server response..</p>
{:then ingredients}
  <ul>
    {#each distinct(ingredients) as distinctType}
      <li>Choose {distinctType} you like!</li>
      <ul>
        {#each ingredients as { name, type }}
          {#if type === distinctType}
            <p>Name: {name}</p>
          {/if}
        {/each}
      </ul>
    {/each}
  </ul>
{/await}
