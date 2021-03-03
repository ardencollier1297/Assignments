// Selects the books UL, Previous button and Next button from the DOM
let bookDOM = document.querySelector(".books");
const prevBtn = document.getElementById("previous");
const nextBtn = document.getElementById("next");

// Selects all of the "page" buttons that have numbers
const pageBtns = document.querySelectorAll(".pgBtn");

// Initialize the current page number at 1
let currentPageNum = 1;
// Declare the maximum records shown on each page
const max = 6;

// Created list of random book objects
const booksList = [
  { bookId: 1, title: "Dune", authorName: "Frank Herbert" },
  { bookId: 2, title: "House of Leaves", authorName: "Mark Z Danielewski" },
  { bookId: 3, title: "Fahrenheit 451", authorName: "Ray Bradbury" },
  { bookId: 4, title: "The Stranger", authorName: "Albert Camus" },
  { bookId: 5, title: "The Plague", authorName: "Albert Camus" },
  { bookId: 6, title: "On the Road", authorName: "Jack Kerouac" },
  { bookId: 7, title: "The Godfather", authorName: "Mario Puzo" },
  { bookId: 8, title: "The Road", authorName: "Cormac McCarthy" },
  { bookId: 9, title: "No Country For Old Men", authorName: "Cormac McCarthy" },
  { bookId: 10, title: "Rhythm of War", authorName: "Brandon Sanderson" },
  {
    bookId: 11,
    title: "The Fellowship of the Ring",
    authorName: "J.R.R. Tolkien",
  },
  { bookId: 12, title: "The Two Towers", authorName: "J.R.R. Tolkien" },
  { bookId: 13, title: "The Return of the King", authorName: "J.R.R. Tolkien" },
  { bookId: 14, title: "The Tell-Tale Heart", authorName: "Edgar Allan Poe" },
  {
    bookId: 15,
    title: "One Flew Over the Cuckoo's Next",
    authorName: "Ken Kesey",
  },
  { bookId: 16, title: "The Shining", authorName: "Stephen King" },
  { bookId: 17, title: "It", authorName: "Stephen King" },
  { bookId: 18, title: "Fight Club", authorName: "Chuck Palahniuk" },
  {
    bookId: 19,
    title: "Harry Potter and the Chamber of Secrets",
    authorName: "J.K. Rowling",
  },
  { bookId: 20, title: "A Tale of Two Cities", authorName: "Charles Dickens" },
];

// This function is called each time a button is pressed, and uses
// the current page number to identify which records to show
const showResults = () => {
  addCurrent();

  // The start and end variables will be manipulated to show
  // which parts of the books list will be shown
  let start = max * (currentPageNum - 1);
  let end = max * currentPageNum;

  // This checks to see if the end exceeds the length of the
  // books list - if so, it instead shows the last max amount of books
  if (end > booksList.length) {
    start = booksList.length - max;
    end = booksList.length;
  }

  // Changes the innerHTML of the books UL to display
  // the books as a list
  bookDOM.innerHTML = booksList
    .slice(start, end)
    .map((s) => {
      return `<li class="list-group-item">ID ${s.bookId}: ${s.title} by ${s.authorName}</li>`;
    })
    // Joined with "" so commas will no longer appear
    .join("");
};

// Goes to the previous page from where the user is at
const prevPg = () => {
  if (currentPageNum > 1) {
    currentPageNum--;
    showResults();
  }
};

// Goes to the next page from where the user is at
const nextPg = () => {
  if (currentPageNum < 4) {
    currentPageNum++;
    showResults();
  }
};

// Adds an event listener to each "page" button that sets the current page
// to be whatever the text content of that button is
pageBtns.forEach((s) => {
  s.addEventListener("click", () => {
    currentPageNum = s.textContent;
    showResults();
  });
});

// Checks to see if the current page number is the same as
// what is listed in the button - Adds the "current" class which
// makes it a light grey
const addCurrent = () => {
  pageBtns.forEach((s) => {
    s.textContent == currentPageNum
      ? s.classList.add("current")
      : s.classList.remove("current");
  });
};

prevBtn.addEventListener("click", () => prevPg());
nextBtn.addEventListener("click", () => nextPg());

// Initialize
showResults();
