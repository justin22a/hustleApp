from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class UserProfile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    username = models.CharField(max_length=100)
    email = models.EmailField()
    phone_number = models.CharField(max_length=20)
    password = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


    def __str__(self):
        return self.username
    
    def __str__(self):
        return self.email

    def __str__(self):
        return self.phone_number
    
    def __str__(self):
        return self.password

    def __str__(self):
        return self.created_at
    
    def __str__(self):
        return self.updated_at

class Product(models.Model):
    name = models.CharField(max_length=100)
    price = models.DecimalField(max_digits=10, decimal_places=2)
    description = models.TextField()
    image = models.ImageField(upload_to='products')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    user_profile = models.ForeignKey(UserProfile, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.name

    def __str__(self):
        return self.price
    
    def __str__(self):
        return self.description
    
    def __str__(self):
        return self.image
    
    def __str__(self):
        return self.created_at
    
    def __str__(self):
        return self.updated_at
    
    def __str__(self):
        return self.user_profile

class Post(models.Model):
    title = models.CharField(max_length=100)
    content = models.TextField()
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    user_profile = models.ForeignKey(UserProfile, on_delete=models.CASCADE)
    type = models.CharField(max_length=100)

    
    def __str__(self):
        return self.title
    
    def __str__(self):
        return self.content

    def __str__(self):
        return self.product
    
    def __str__(self):
        return self.created_at
    
    def __str__(self):
        return self.user_profile
    


class Comment(models.Model):
    post = models.ForeignKey(Post, on_delete=models.CASCADE)
    user_profile = models.ForeignKey(UserProfile, on_delete=models.CASCADE)
    text = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    type = models.CharField(max_length=100)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)

    
    def __str__(self):
        return f"Comment on '{self.post.title}'"
    
    def __str__(self):
        return self.text

    def __str__(self):
        return self.created_at

    def __str__(self):
        return self.type

    def __str__(self):
        return self.product
    

    


    