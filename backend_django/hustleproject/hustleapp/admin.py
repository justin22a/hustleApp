from django.contrib import admin
from .models import UserProfile, Product, Post, Comment

# Register your models here.
admin.site.register(UserProfile)
admin.site.register(Product)
admin.site.register(Post)
admin.site.register(Comment)
