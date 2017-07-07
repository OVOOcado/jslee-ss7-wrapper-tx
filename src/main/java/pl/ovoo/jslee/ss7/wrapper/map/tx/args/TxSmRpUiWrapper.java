/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import java.util.Arrays;

import pl.ovoo.jslee.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper;


/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpUiWrapper implements SmRpUiWrapper{

    private String text;
    private byte[] data;
    private DataCodingWrapper charset;
    private String originatingAddress;
    private boolean moreMessagesToSend;
    private boolean isConcatened;
    private int messageRef;
    private int segmCnt;
    private int segmNum;

    public TxSmRpUiWrapper() {super();}

    @Override
    public String getText() {
        return this.text;
    }
    public void setText(String text){
        this.text = text;
    }

    @Override
    public byte[] getData() {
        return this.data;
    }
    public void setData(byte[] data){
        this.data = data;
    }

    @Override
    public DataCodingWrapper getCharset() {
        return this.charset;
    }
    public void setCharset(DataCodingWrapper charset){
        this.charset = charset;
    }

    @Override
    public String getOriginatingAddress() {
        return this.originatingAddress;
    }
    public void setOriginatingAddress(String originatingAddress){
        this.originatingAddress = originatingAddress;
    }

    @Override
    public boolean getMoreMessagesToSend(){
    	return this.moreMessagesToSend;
    }
    public void setMoreMessagesToSend(boolean moreMessagesToSend){
        this.moreMessagesToSend = moreMessagesToSend;
    }

    @Override
    public boolean getIsConcatened() {
		return isConcatened;
	}

	public void setIsConcatened(boolean isConcatened) {
		this.isConcatened = isConcatened;
	}

	@Override
    public int getMessageRef() {
		return messageRef;
	}

	public void setMessageRef(int messageRef) {
		this.messageRef = messageRef;
	}

	@Override
    public int getSegmCnt() {
		return segmCnt;
	}

	public void setSegmCnt(int segmCnt) {
		this.segmCnt = segmCnt;
	}

	@Override
    public int getSegmNum() {
		return segmNum;
	}

	public void setSegmNum(int segmNum) {
		this.segmNum = segmNum;
	}

	@Override
	public String toString() {
		return "TxSmRpUiWrapper [text=" + text + ", data=" + Arrays.toString(data) + ", charset=" + charset
				+ ", originatingAddress=" + originatingAddress + ", moreMessagesToSend=" + moreMessagesToSend
				+ ", isConcatened=" + isConcatened + ", messageRef=" + messageRef + ", segmCnt=" + segmCnt
				+ ", segmNum=" + segmNum + "]";
	}
}
