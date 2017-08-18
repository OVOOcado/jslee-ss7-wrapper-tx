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

    /** The text. */
    private String text;
    
    /** The data. */
    private byte[] data;
    
    /** The charset. */
    private DataCodingWrapper charset;
    
    /** The originating address. */
    private String originatingAddress;
    
    /** The more messages to send. */
    private boolean moreMessagesToSend;
    
    /** The is concatened. */
    private boolean isConcatened;
    
    /** The message ref. */
    private int messageRef;
    
    /** The segm cnt. */
    private int segmCnt;
    
    /** The segm num. */
    private int segmNum;

    /**
     * Instantiates a new tx sm rp ui wrapper.
     */
    public TxSmRpUiWrapper() {super();}

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getText()
     */
    @Override
    public String getText() {
        return this.text;
    }
    
    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text){
        this.text = text;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getData()
     */
    @Override
    public byte[] getData() {
        return this.data;
    }
    
    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(byte[] data){
        this.data = data;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getCharset()
     */
    @Override
    public DataCodingWrapper getCharset() {
        return this.charset;
    }
    
    /**
     * Sets the charset.
     *
     * @param charset the new charset
     */
    public void setCharset(DataCodingWrapper charset){
        this.charset = charset;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getOriginatingAddress()
     */
    @Override
    public String getOriginatingAddress() {
        return this.originatingAddress;
    }
    
    /**
     * Sets the originating address.
     *
     * @param originatingAddress the new originating address
     */
    public void setOriginatingAddress(String originatingAddress){
        this.originatingAddress = originatingAddress;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getMoreMessagesToSend()
     */
    @Override
    public boolean getMoreMessagesToSend(){
    	return this.moreMessagesToSend;
    }
    
    /**
     * Sets the more messages to send.
     *
     * @param moreMessagesToSend the new more messages to send
     */
    public void setMoreMessagesToSend(boolean moreMessagesToSend){
        this.moreMessagesToSend = moreMessagesToSend;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getIsConcatened()
     */
    @Override
    public boolean getIsConcatened() {
		return isConcatened;
	}

	/**
	 * Sets the checks if is concatened.
	 *
	 * @param isConcatened the new checks if is concatened
	 */
	public void setIsConcatened(boolean isConcatened) {
		this.isConcatened = isConcatened;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getMessageRef()
	 */
	@Override
    public int getMessageRef() {
		return messageRef;
	}

	/**
	 * Sets the message ref.
	 *
	 * @param messageRef the new message ref
	 */
	public void setMessageRef(int messageRef) {
		this.messageRef = messageRef;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getSegmCnt()
	 */
	@Override
    public int getSegmCnt() {
		return segmCnt;
	}

	/**
	 * Sets the segm cnt.
	 *
	 * @param segmCnt the new segm cnt
	 */
	public void setSegmCnt(int segmCnt) {
		this.segmCnt = segmCnt;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper#getSegmNum()
	 */
	@Override
    public int getSegmNum() {
		return segmNum;
	}

	/**
	 * Sets the segm num.
	 *
	 * @param segmNum the new segm num
	 */
	public void setSegmNum(int segmNum) {
		this.segmNum = segmNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxSmRpUiWrapper [text=" + text + ", data=" + Arrays.toString(data) + ", charset=" + charset
				+ ", originatingAddress=" + originatingAddress + ", moreMessagesToSend=" + moreMessagesToSend
				+ ", isConcatened=" + isConcatened + ", messageRef=" + messageRef + ", segmCnt=" + segmCnt
				+ ", segmNum=" + segmNum + "]";
	}
}
