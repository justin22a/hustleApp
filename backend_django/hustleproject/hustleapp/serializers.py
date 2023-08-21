from rest_framework import serializers
from .models import Comment, UserProfile, Product, Posting



class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = '__all__'

class PostingSerializer(serializers.ModelSerializer):
    class Meta:
        model = Posting
        fields = '__all__'

class CommentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'

class UserProfileSerializer(serializers.ModelSerializer):
    products = ProductSerializer(many=True, read_only=True)
    postings = PostingSerializer(many=True, read_only=True)

    class Meta:
        model = UserProfile
        fields = '__all__'
