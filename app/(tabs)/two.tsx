import { StyleSheet, Image, FlatList } from 'react-native';
import { Text, View } from '@/components/Themed';

const DATA = [
  { id: '1', imageUri: require('../../assets/images/basketball.png'), title: 'Title 1', description: 'Description 1' },
  { id: '2', imageUri: require('../../assets/images/basketball.png'), title: 'Title 2', description: 'Description 2' },
  { id: '3', imageUri: require('../../assets/images/basketball.png'), title: 'Title 3', description: 'Description 3' },
  { id: '4', imageUri: require('../../assets/images/basketball.png'), title: 'Title 4', description: 'Description 4' },
  // Add more items as needed
];

export default function TabTwoScreen() {
  return (
    <View style={styles.container}>
      <FlatList
        data={DATA}
        keyExtractor={item => item.id}
        ItemSeparatorComponent={() => <View style={styles.separator} />}
        renderItem={({ item }) => (
          <View style={styles.item}>
            <Image source={item.imageUri} style={styles.image} />
            <Text style={styles.title}>{item.title}</Text>
            <Text style={styles.description}>{item.description}</Text>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    paddingHorizontal: 15,
  },
  item: {
    flexDirection: 'row',
    marginBottom: 10,
    alignItems: 'center',
    paddingVertical: 5,
  },
  image: {
    width: 50,
    height: 50,
    borderRadius: 25,
    marginRight: 15,
  },
  title: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  description: {
    fontSize: 16,
  },
  separator: {
    borderBottomColor: '#737373',
    borderBottomWidth: StyleSheet.hairlineWidth,
  },
});
