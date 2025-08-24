# Client-Server Application for OOO "Garpix"

## About
This project was completed by a university team during internship practice. 
The goal is to develop a client–server application using the Agile Scrum methodology.


## Tech Stack
- Frontend: React
- Deployment: Vercel (frontend), any server/cloud for backend
- VCS: Git + GitHub

## Local Development
1. Clone the repository
```bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```
2. Install dependencies
```bash
npm install
```
or
```bash
yarn install
```
3. Start the development server
```bash
npm start
```
The app will be available at: http://localhost:3000

## Deploy to Vercel
1. Create an account at https://vercel.com/ and connect GitHub
2. Click "New Project" and import your repository
3. Build settings:
   - Framework Preset: Create React App (if CRA) or Other
   - Build Command: npm run build
   - Output Directory: build
4. Click "Deploy"
5. After the build completes, you will get a URL like: https://your-app.vercel.app

## Environment Variables
If your app needs environment variables:
- Go to Vercel → Project → Settings → Environment Variables
- Add variables (for example: REACT_APP_API_URL)
- Redeploy after changes
