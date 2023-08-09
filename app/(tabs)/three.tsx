import React, { useState } from 'react';
import { StyleSheet, FlatList, TextInput, Button, KeyboardAvoidingView, TouchableOpacity } from 'react-native';
import { Text, View } from '@/components/Themed';

type User = {
  id: string;
  name: string;
};

type Message = {
  id: string;
  text: string;
  user: 'currentUser' | 'selectedUser';
};

const USERS: User[] = [
  { id: '1', name: 'User1' },
  { id: '2', name: 'User2' },
];

export default function MessagingTab() {
  const [selectedUser, setSelectedUser] = useState<User | null>(null);
  const [messages, setMessages] = useState<Message[]>([]);
  const [input, setInput] = useState('');

  const handleSendMessage = () => {
    if (input.trim().length === 0) return;

    const newMessage: Message = {
      id: Date.now().toString(),
      text: input,
      user: 'currentUser',
    };

    setMessages((prevMessages) => [...prevMessages, newMessage]);
    setInput('');
  };

  const handleBackPress = () => {
    setSelectedUser(null);
    setMessages([]);
  };

  if (selectedUser) {
    return (
      <View style={styles.container}>
        <View style={styles.chatHeader}>
          <View style={styles.backButtonContainer}>
            <TouchableOpacity onPress={handleBackPress} style={styles.backButton}>
              <Text>← Back</Text>
            </TouchableOpacity>
          </View>
          <View style={styles.headerContainer}>
            <Text style={styles.header}>{selectedUser.name}</Text>
          </View>
          <View style={styles.spacer} />
        </View>
        <FlatList
          data={messages}
          renderItem={({ item }) => (
            <View style={item.user === 'currentUser' ? styles.currentUserMsg : styles.selectedUserMsg}>
              <Text>{item.text}</Text>
            </View>
          )}
          keyExtractor={(item) => item.id}
        />
        <KeyboardAvoidingView behavior="padding" style={styles.inputContainer}>
          <TextInput
            style={styles.input}
            value={input}
            onChangeText={setInput}
            placeholder="Type your message..."
          />
          <Button title="Send" onPress={handleSendMessage} />
        </KeyboardAvoidingView>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Select a User to Chat</Text>
      <FlatList
        data={USERS}
        renderItem={({ item }) => (
          <TouchableOpacity onPress={() => setSelectedUser(item)} style={styles.userList}>
            <Text>{item.name}</Text>
          </TouchableOpacity>
        )}
        keyExtractor={(item) => item.id}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
  header: {
    fontSize: 20,
    marginBottom: 10,
  },
  chatHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 10,
  },
  backButtonContainer: {
    flex: 1,
    alignItems: 'flex-start',
  },
  headerContainer: {
    flex: 2,
    alignItems: 'center',
  },
  spacer: {
    flex: 1,
  },
  backButton: {
    marginRight: 10,
  },
  userList: {
    padding: 15,
    borderBottomWidth: 1,
    borderBottomColor: '#e6e6e6',
  },
  currentUserMsg: {
    backgroundColor: '#e6e6e6',
    padding: 10,
    borderRadius: 10,
    marginVertical: 5,
    alignSelf: 'flex-end',
  },
  selectedUserMsg: {
    backgroundColor: '#0099ff',
    padding: 10,
    borderRadius: 10,
    marginVertical: 5,
    alignSelf: 'flex-start',
    color: 'white',
  },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 5,
  },
  input: {
    flex: 1,
    backgroundColor: 'white',
    paddingHorizontal: 10,
    borderRadius: 15,
    marginHorizontal: 5,
    height: 40,
  },
});

