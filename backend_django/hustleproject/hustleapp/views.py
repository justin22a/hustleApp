from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework.authentication import TokenAuthentication
from rest_framework.permissions import IsAuthenticated
from .models import UserProfile, Product, Posting
from .serializers import UserProfileSerializer, ProductSerializer, PostingSerializer

class UserProfileView(APIView):
    authentication_classes = [TokenAuthentication]
    permission_classes = [IsAuthenticated]

    def get(self, request):
        user_profile = UserProfile.objects.get(user=request.user)
        serializer = UserProfileSerializer(user_profile)
        return Response(serializer.data)

class ProductListView(APIView):
    authentication_classes = [TokenAuthentication]
    permission_classes = [IsAuthenticated]

    def get(self, request):
        products = Product.objects.filter(user=request.user)
        serializer = ProductSerializer(products, many=True)
        return Response(serializer.data)

class PostingListView(APIView):
    authentication_classes = [TokenAuthentication] 
    permission_classes = [IsAuthenticated]

    def get(self, request):
        postings = Posting.objects.filter(user=request.user)
        serializer = PostingSerializer(postings, many=True)
        return Response(serializer.data)
