import React from 'react';
import { createRoot } from 'react-dom/client';
import './index.scss';
import App from './App';
import { QueryClient, QueryClientProvider } from 'react-query';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080';

const queryClient = new QueryClient();

const root = createRoot( document.getElementById('root'));
root.render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <App />
        </QueryClientProvider>
    </React.StrictMode>
);