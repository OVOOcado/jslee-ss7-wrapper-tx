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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;

import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;


/**
 * TxAnyTimeInterrogationResultWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationResultWrapper implements AnyTimeInterrogationResultWrapper {

    /** The subscriber info wrapper. */
    private MAPSubscriberInfoWrapper subscriberInfoWrapper;

    /** The logger. */
    private static Logger logger = Logger.getLogger(TxAnyTimeInterrogationResultWrapper.class);

    /**
     * Instantiates a new tx any time interrogation result wrapper.
     *
     * @param subscriberInfoWrapper the subscriber info wrapper
     */
    public TxAnyTimeInterrogationResultWrapper(final MAPSubscriberInfoWrapper subscriberInfoWrapper) {
        super();
        this.subscriberInfoWrapper = subscriberInfoWrapper;
    }

    /**
     * Instantiates a new tx any time interrogation result wrapper.
     */
    public TxAnyTimeInterrogationResultWrapper() {

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper#getSubscriberInfo()
     */
    @Override
    public MAPSubscriberInfoWrapper getSubscriberInfo() {
        return subscriberInfoWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper#hasSubscriberInfo()
     */
    @Override
    public boolean hasSubscriberInfo() {
        return subscriberInfoWrapper != null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxAnyTimeInterrogationResultWrapper [subscriberInfoWrapper=" + subscriberInfoWrapper + "]";
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
     */
    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        this.subscriberInfoWrapper = (MAPSubscriberInfoWrapper) oin.readObject();
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(subscriberInfoWrapper);
    }

}
