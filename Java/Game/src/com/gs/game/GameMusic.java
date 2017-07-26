package com.gs.game;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class GameMusic {

	
	private Sequencer sr;
	
	public void play(String path) {
		try {
			// ������Ϣ
			Sequence s = MidiSystem.getSequence(GameMusic.class.getResourceAsStream(path));
			// ��ȡ�ܹ����������Ϣ�Ķ���
			sr = MidiSystem.getSequencer();
			// �򿪴�������Ķ���
			sr.open();
			// ��Ӹ�����������
			sr.setSequence(s);
			// ��ʼ����
			sr.start();
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		sr.stop();
	}
	
}
