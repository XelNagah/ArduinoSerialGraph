# ArduinoSerialGraph
Plot Arduino's data reading from serial interface using java, RXTX and jFreeChart

ArduinoSerialGraph expects an "A0" string to read the A0 data, "A1" for A1 data, and so on. 
Then, it uses the value for the plot. It distinguishes the readings via the "Ax" string.

So, set outputs in Arduino in the following manner:

---
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
  pinMode(A0,INPUT);
  pinMode(A1,INPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  // read the input on analog pin 0:
  int sensorValue1 = analogRead(A0);
  int sensorValue2 = analogRead(A1);
  // print out the value you read:
  Serial.println("A0");
  Serial.println(sensorValue1);
  Serial.println("A1");
  Serial.println(sensorValue2);
  delay(100);        // delay in between reads for stability
}
  ---
