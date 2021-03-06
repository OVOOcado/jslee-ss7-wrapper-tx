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

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;


/**
 * OcCallingPartyNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRedirectingPartyNumberWrapper implements RedirectingPartyNumberWrapper {

    /** The redirecting party number. */
    private final RedirectingPartyIDCap redirectingPartyNumber;

    /**
     * Instantiates a new tx redirecting party number wrapper.
     *
     * @param redirectingPartyNumber the redirecting party number
     */
    public TxRedirectingPartyNumberWrapper(final RedirectingPartyIDCap redirectingPartyNumber) {
        this.redirectingPartyNumber = redirectingPartyNumber;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#getAddress()
     */
    @Override
    public String getAddress() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber().getAddress();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#getNature()
     */
    @Override
    public Nature getNature() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return Nature.valueOf(redirectingPartyNumber.getRedirectingNumber().getNatureOfAddressIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#getNumberingPlan()
     */
    @Override
    public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return NumberingPlan.valueOf(redirectingPartyNumber.getRedirectingNumber().getNumberingPlanIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#hasAddress()
     */
    @Override
    public boolean hasAddress() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null && redirectingPartyNumber.getRedirectingNumber().getAddress() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#hasNature()
     */
    @Override
    public boolean hasNature() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#hasNumberingPlan()
     */
    @Override
    public boolean hasNumberingPlan() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#hasPresentation()
     */
    @Override
    public boolean hasPresentation() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper#getPresentation()
     */
    @Override
    public Presentation getPresentation() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return Presentation.valueOf(redirectingPartyNumber.getRedirectingNumber().getAddressRepresentationRestrictedIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /**
     * Gets the tx redirecting party number.
     *
     * @return the tx redirecting party number
     */
    public RedirectingPartyIDCap getTxRedirectingPartyNumber() {
        return redirectingPartyNumber;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxRedirectingPartyNumberWrapper [redirectingPartyNumber=" + redirectingPartyNumber + "]";
	}
    
}
