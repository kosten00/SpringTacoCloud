export class Order {
    name = "";
    street = "";
    city = "";
    state = "";
    zip = "";
    creditCard = "";
    creditCardExpiration = "";
    cvv = "";

    hasAllFiledsValid() {
        return this.hasValidName() &&
            this.hasValidStreet() &&
            this.hasValidCity() &&
            this.hasValidState() &&
            this.hasValidZip() &&
            this.hasValidCc() &&
            this.hasValidCcExpiration() &&
            this.hasValidCvv();
    }

    hasValidName() {
        return /\w+/.test(this.name);
    }

    hasValidStreet() {
        return /\w+/.test(this.street);
    }

    hasValidCity() {
        return /\w+/.test(this.city);
    }

    hasValidState() {
        return /\w+/.test(this.state);
    }

    hasValidZip() {
        return /\w+/.test(this.zip);
    }

    hasValidCc() {
        return /\w+/.test(this.creditCard);
    }

    hasValidCcExpiration() {
        return /\w+/.test(this.creditCardExpiration);
    }

    hasValidCvv() {
        return /\w+/.test(this.cvv);
    }
}