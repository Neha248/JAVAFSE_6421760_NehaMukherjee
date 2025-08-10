import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Blog Posts heading', () => {
  render(<App />);
  const heading = screen.getByText(/Blog Posts/i);
  expect(heading).toBeInTheDocument();
});