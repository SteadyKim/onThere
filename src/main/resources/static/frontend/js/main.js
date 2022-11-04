var picker = new Pikaday({ 
    field: document.getElementById('datepicker'),
    format: 'yyyy-MM-dd',
    toString(date, format) {
      let day = ("0" + date.getDate()).slice(-2);
      let month = ("0" + (date.getMonth() + 1)).slice(-2);
      let year = date.getFullYear();
      return `${year}-${month}-${day}`;
    }
  });