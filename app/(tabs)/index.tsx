import { StyleSheet, Image, FlatList } from 'react-native';
import { Text, View } from '@/components/Themed';

const posts = [
  // Add the URLs of your images here
  
  { id: '1', imageUri: require('../../assets/images/codes.jpeg') },
  // For other local images, do the same:
   { id: '2', imageUri: require('../../assets/images/basketball.png') },
   { id: '3', imageUri: require('../../assets/images/garbagecan.jpeg') },
   
  // ...
];

export default function TabOneScreen() {
  return (
    <View style={styles.container}>
      <Image 
        source={require('../../assets/images/me.png')} 
        style={styles.profileImage}
      />
      <Text style={styles.title}>Justin Adam</Text>
      <Text style={styles.subtitle}>Email: justin.adam@gmail.com</Text>
      <Text style={styles.subtitle}>I sell products AND services!</Text>
      
      <View style={styles.gallery}>
        <FlatList
          data={posts}
          keyExtractor={item => item.id}
          numColumns={3}
          renderItem={({ item }) => (
            <Image
              style={styles.image}
              source={item.imageUri}
            />
          )}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    paddingTop: 50,
  },
  profileImage: {
    width: 100,
    height: 100,
    borderRadius: 50,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginTop: 20,
  },
  subtitle: {
    fontSize: 16,
    color: '#888',
  },
  gallery: {
    flex: 1,
    marginTop: 30,
    alignSelf: 'stretch',
  },
  image: {
    width: '33.33%',
    height: 100,
  },
});
