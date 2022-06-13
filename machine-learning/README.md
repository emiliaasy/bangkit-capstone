# MACHINE LEARNING

## INTRODUCTION

We build 2 models for the application which has 2 categories in it. We got the dataset from Kaggle. For the result, the first model for the animal category, in this particular model we used the mobilenet v2 pre-trained model and got 90+ accuracy and the second model was for the house category and we got 86+ accuracy. All of these 2 models have obviously been preprocessed in the first place before being fed to the model such as creating and managing directories and files and data augmentation to make the models more robust. In the end, we convert the models to tensorflow lite for further deployment.

## 1. Animal Image Classification

### Dataset

Animal dataset collected from https://www.kaggle.com/datasets/iamsouravbanerjee/animal-image-dataset-90-different-animals. 
This Dataset Consist of 5400 Animal Images in 90 Different Classes 

### Technologies

- Python 3.7.13
- TensorFlow 2.8.2
- Pandas 1.3.5
- Numpy 1.21.6
- Matplotlib 3.2.2

### Transfer Learning
We use Convolutional Neural Network and the base model from the mobilenet v2 pre-trained model.

### Launch

https://colab.research.google.com/drive/1cxH6KEvanCQ1KYBUF-j412kkVBwtBeFF?authuser=2#scrollTo=lGziEno0LAZH

## 2. Furniture Image Classification 

### Dataset 
Furniture dataset collected from https://www.kaggle.com/competitions/day-3-kaggle-competition/data. We only took 3 of 5 data, namely bed, chair, and table.
The distribution as follows :

- Bed folder contains 1,100 images.
- Chair folder contains 1,627 images
- Table folder contains 1296 images.

### Technologies
- Python 3.7.13
- TensorFlow 2.8.2
- Pandas 1.3.5
- Numpy 1.21.6
- Matplotlib 3.2.2

### Transfer Learning
We use Convolutional Neural Network and the base model from the mobilenet v2 pre-trained model.

### Launch
https://colab.research.google.com/drive/1bBDx56nTaC5RgBe6eHDrx53AFwCVp9_i?usp=sharing





