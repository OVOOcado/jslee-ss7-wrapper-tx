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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBearerServiceCodeWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ExtTeleserviceCodeWrapper;


/**
 * TxExtBasicServiceCodeWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxExtBasicServiceCodeWrapper implements ExtBasicServiceCodeWrapper {

    /** The ext bearer service code wrapper. */
    private transient ExtBearerServiceCodeWrapper extBearerServiceCodeWrapper = null;
    
    /** The ext teleservice code wrapper. */
    private transient ExtTeleserviceCodeWrapper extTeleserviceCodeWrapper = null;

    /** The ext basic service code. */
    private final ExtBasicServiceCode extBasicServiceCode;

    /**
     * Instantiates a new tx ext basic service code wrapper.
     *
     * @param extBasicServiceCode the ext basic service code
     */
    public TxExtBasicServiceCodeWrapper(final ExtBasicServiceCode extBasicServiceCode) {
        this.extBasicServiceCode = extBasicServiceCode;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper#isExtBearerServiceChosen()
     */
    @Override
    public boolean isExtBearerServiceChosen() {
        return extBasicServiceCode.getExtBearerService() != null && extBasicServiceCode.getExtTeleservice() == null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper#isExtTeleserviceChosen()
     */
    @Override
    public boolean isExtTeleserviceChosen() {
        return extBasicServiceCode.getExtBearerService() == null && extBasicServiceCode.getExtTeleservice() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper#getExtBearerServiceCode()
     */
    @Override
    public ExtBearerServiceCodeWrapper getExtBearerServiceCode() {
        if (this.extBearerServiceCodeWrapper == null && extBasicServiceCode.getExtBearerService() != null) {
            this.extBearerServiceCodeWrapper = new TxExtBearerServiceCodeWrapper(
                    extBasicServiceCode.getExtBearerService());
        }
        return this.extBearerServiceCodeWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper#getExtTeleserviceCode()
     */
    @Override
    public ExtTeleserviceCodeWrapper getExtTeleserviceCode() {
        if (this.extTeleserviceCodeWrapper == null && extBasicServiceCode.getExtTeleservice() != null) {
            this.extTeleserviceCodeWrapper = new TxExtTeleserviceCodeWrapper(extBasicServiceCode.getExtTeleservice());
        }
        return this.extTeleserviceCodeWrapper;
    }

    /**
     * Gets the ext basic service code.
     *
     * @return the ext basic service code
     */
    public ExtBasicServiceCode getExtBasicServiceCode() {
        return this.extBasicServiceCode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxExtBasicServiceCodeWrapper [extBasicServiceCode=" + extBasicServiceCode + "]";
    }

}
