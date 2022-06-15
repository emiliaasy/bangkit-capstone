const Firestore = require('@google-cloud/firestore');

const db = new Firestore({
  projectId: 'jovial-rex-351311',
  keyFilename: './jovial-rex-351311-1cee0c462786.json',
});

module.exports = db;