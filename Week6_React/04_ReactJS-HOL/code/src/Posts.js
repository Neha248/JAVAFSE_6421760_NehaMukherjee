import React, { Component } from "react";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        this.setState({ posts: data });
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
        this.setState({ hasError: true });
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  // In React 19, componentDidCatch still works but in strict mode
  // errors during render don't always reach here in dev
  componentDidCatch(error, info) {
    console.error("Error caught in component:", error, info);
    alert("An error occurred: " + error.message);
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong.</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.length === 0 ? (
          <p>Loading...</p>
        ) : (
          this.state.posts.map((post) => (
            <div key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
              <hr />
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Posts;
