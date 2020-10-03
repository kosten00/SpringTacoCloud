import { writable } from 'svelte/store';

export const storedTaco = writable({
    name: ''
});